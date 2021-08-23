package com.sdt.util;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.*;

public class SignUtil {
	
	//获得一对公钥私钥
	public static KeyPair getkey() throws Exception {
		KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
		KeyPair generateKeyPair = generator.generateKeyPair();
		return generateKeyPair;
	}

	//拿到字符串   拿到私钥   对数据进行签名
	public static String signqm(String text, String privateKey) throws Exception {
		Signature signature = Signature.getInstance("SHA256WithRSA");// SHA256WithRSA   支付宝默认  是这种
//		Signature signature = Signature.getInstance("MD5withRSA");// MD5withRSA
		PrivateKey privateKey2 = (PrivateKey) getPrivateKey(privateKey);
		// 用私钥初始化signature
		signature.initSign(privateKey2);
		// 更新原始字符串
		signature.update(text.getBytes("utf-8"));
		byte[] bytes = signature.sign();
		String sign = Base64.getEncoder().encodeToString(bytes);
		return sign;
	}
	
	//拿到公钥  拿到字符串数据  拿到sign  对数据进行验签
	public static boolean yansign(String publickey, String sign, String test) throws Exception {
		//指定签名的Signature对象
		Signature signature = Signature.getInstance("SHA256WithRSA");// SHA256WithRSA   支付宝默认  是这种
//		Signature signature = Signature.getInstance("MD5withRSA");// MD5withRSA
		//获得公钥key对象
		Key publicKey2 = getPublicKey(publickey);
		PublicKey publickey3 = (PublicKey) publicKey2;
		// 用公钥初始化signature
		signature.initVerify(publickey3);
		// 更新原始字符串
		signature.update(test.getBytes());
		// 校验签名是否正确
		boolean result = signature.verify(Base64.getDecoder().decode(sign));
		return result;
	}

	//拿到私钥，初始化私钥
	private static Key getPrivateKey(String key) throws Exception {
		PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(key));
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		Key k = keyFactory.generatePrivate(keySpec);
		return k;
	}

	//拿到公钥，初始化公钥
	private static Key getPublicKey(String key) throws Exception {
		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(key));
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		Key k = keyFactory.generatePublic(keySpec);
		return k;
	}
	
	//拿到map   从map转换成字符串string
	public static String map_to_string(Map<String, String> params) {
		StringBuffer content = new StringBuffer();
		Set<String> keys = params.keySet();
		int i = 0;
		for (String key:keys) {
			String value = params.get(key);
			content.append((i == 0 ? "" : "&") + key + "=" + value);
			i++;
		}
		return content.toString();
	}
	
	//拿到map，验签的时候，必须要去掉map中的sign 和sign_type 这两个key，然后再转换成string 
	public static String map_quchu_signandsigntype(Map<String, String> params) {
		params.remove("sign");
		params.remove("sign_type");
		
		StringBuffer content = new StringBuffer();
		Set<String> keys = params.keySet();
		int i = 0;
		for (String key:keys) {
			String value = params.get(key);
			content.append((i == 0 ? "" : "&") + keys + "=" + value);
			i++;
		}
		return content.toString();
	}
	
	//拿到map  拿到公钥   不去除sign_type  用map中的sign  对数据进行验签
	public static boolean yanqian(Map<String, String> map,String publickey) throws Exception {
		
		String sign = map.get("sign");
		map.remove("sign");
		map.remove("sign_type");
		String map_to_string = map_to_string(map);
		boolean yansign = yansign(publickey, sign, map_to_string);
		return yansign;
	}

	public static String MD5(String data) throws Exception {
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] array = md.digest(data.getBytes("UTF-8"));
		StringBuilder sb = new StringBuilder();
		for (byte item : array) {
			sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
		}
		return sb.toString().toUpperCase();
	}



	/**
	 * 支付宝的验签方法
	 * @param req
	 * @return
	 */
	public static boolean checkSign(HttpServletRequest req) {
		Map<String, String[]> requestMap = req.getParameterMap();
		Map<String, String> paramsMap = new HashMap<>();
		requestMap.forEach((key, values) -> {
			String strs = "";
			for(String value : values) {
				strs = strs + value;
			}
			/*System.out.println(("key值为"+key+"value为："+strs));*/
			paramsMap.put(key, strs);
		});

		//调用SDK验证签名
		try {
			return  AlipaySignature.rsaCheckV1(paramsMap, com.sdt.pojo.Key.getAliPublicKey(), "utf-8", "RSA2");
		} catch (AlipayApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("*********************验签失败********************");
			return false;
		}
	}

	public static String getRandomString(int length){
		//定义一个字符串（A-Z，a-z，0-9）即62位；
		String str="zxcvbnmlkjhgfdsaqwertyuiopQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
		//由Random生成随机数
		Random random=new Random();
		StringBuffer sb=new StringBuffer();
		//长度为几就循环几次
		for(int i=0; i<length; ++i){
			//产生0-61的数字
			int number=random.nextInt(62);
			//将产生的数字通过length次承载到sb中
			sb.append(str.charAt(number));
		}
		//将承载的字符转换成字符串
		return sb.toString();
	}

	public static String getIpAddr(HttpServletRequest request) {
		String ipAddress = request.getHeader("x-forwarded-for");
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getRemoteAddr();
			if (ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")) {
				//根据网卡取本机配置的IP
				InetAddress inet = null;
				try {
					inet = InetAddress.getLocalHost();
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}
				ipAddress = inet.getHostAddress();
			}
		}
		//对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
		if (ipAddress != null && ipAddress.length() > 15) { //"***.***.***.***".length() = 15
			if (ipAddress.indexOf(",") > 0) {
				ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
			}
		}
		return ipAddress;
	}
}
// 大量代码
$(function () {

// ######################################################################
// 全选功能
// 当大的checkbox发生改变，小的checkbox也会改变
// 如果大的选择了，小的就要选中，如果大的没选中，小的也不会选择
	// 获取添加事件
	$('.checkall').change(function () {

		// 获取checked的值
		var flag = $(this).prop('checked');
		// 操作小checkbox// 另外一个checkekall
		$('.j-checkbox,.checkall').prop('checked', flag);

		// 背景颜色
		if (flag) {
			// 如果为true所有的cart-item都得添加背景，反之不添加
			$('.cart-item').addClass('check-cart-item');
		} else {
			$('.cart-item').removeClass('check-cart-item');
		}
		

	});
// ##########################################################################
// 小选项全选
// 任何一个小checkbox发生改变，都有可能应该想到大的
// 如果都选中了，大的就要选中，如果小的没有全部都选，那么大的就不选择
	// 添加事件
	$('.j-checkbox').change(function () {
		// 小的是否都选择
		// 原理:我们只要知道总共有多少个小的checkbox，还得知道选择的个数
		// 如果个数相同，说明都选择，如果个数不同说明有的没有选择
		var len1 = $('.j-checkbox').length;// 代表总个数
		var len2 = $('.j-checkbox:checked').length;
		// 全选按钮
		$('.checkall').prop('checked',len1 == len2);
		// if (len1 == len2) {
		// 	$('.checkall').prop('checked',true);
		// } else{
		// 	$('.checkall').prop('checked',false);
		// }

		if ($(this).prop('checked')) {
			$(this).parents('.cart-item').addClass('check-cart-item');
		} else {
			$(this).parents('.cart-item').removeClass('check-cart-item');
		}


	});

// ###########################################################################
// 点击增加
// 获取内容，让内容加1，再设置给里面的内容
	// 添加事件
	$('.increment').click(function () {
		// 获取内容value值
		var n = $(this).siblings('.itxt').val();
		// 增加
		n++;
		// 设置给input
		$(this).siblings('.itxt').val(n);


		// 修改小计
		// 获取单价，数量，相乘把得到的结果放入小计元素
		// 获取单价
		var price = $(this).parent().parent().siblings('.p-price').html();
		// 截取
		price = price.substr(1);
		// 相乘
		price = price * n;
		// 放到小计里面
		// 保留两位有效数字
		// num.toFixed(2)
		$(this).parent().parent().siblings('.p-sum').html( '￥' + price.toFixed(2));

		getSum();

	});
// ###############################################################################
// 点击减少
// 获取内容，让内容加1，再设置给里面的内容
	// 添加事件
	$('.decrement').click(function () {
		// 获取内容value值
		var n = $(this).siblings('.itxt').val();
		if (n == 1) {
			return;// 函数遇到return会立刻跳出
		}
		// 减少
		n--;
		// 设置给input
		$(this).siblings('.itxt').val(n);


		// 修改小计
		// 获取单价，数量，相乘把得到的结果放入小计元素
		// 获取单价
		var price = $(this).parent().parent().siblings('.p-price').html();
		// 截取
		price = price.substr(1);
		// 相乘
		price = price * n;
		// 放到小计里面
		// 保留两位有效数字
		// num.toFixed(2)
		$(this).parent().parent().siblings('.p-sum').html( '￥' + price.toFixed(2));

		getSum();
		
	});
// ###################################################################################
// 用户直接输入数量
// 当itxt发生改变时候，继续计算小计，数量*单价=小计 
	// 添加事件
	$('.itxt').change(function () {
		// 获取数量
		var n = $(this).val();
		// 修改小计
		// 获取单价，数量，相乘把得到的结果放入小计元素
		// 获取单价
		var price = $(this).parent().parent().siblings('.p-price').html();
		// 截取
		price = price.substr(1);
		// 相乘
		price = price * n;
		// 放到小计里面
		// 保留两位有效数字
		// num.toFixed(2)
		$(this).parent().parent().siblings('.p-sum').html( '￥' + price.toFixed(2));



	});
// #####################################################################################
// 求总件数和总价格
// 因为多次求结果，所以最好封装
	getSum();
	function getSum () {

		var count = 0;// 用来保存总件数
		var sum = 0;// 用来保存总价格

		// 求总件数，把所以商品数量累加到count
		$('.itxt').each(function (i, elm) {
			// 获取每个itxt的val值累加
			count =  count + parseInt( $(elm).val() );
		});
		$('.amount-sum em').text(count);

		// p-sum里面的值分别拿出来，累加
		$('.p-sum').each(function (i, elm) {
			// 获取内容
			var valZhi = $(elm).text();
			// 截取字符串
			valZhi = valZhi.substr(1);
			// 转换累加
			sum = sum + parseFloat( valZhi );

		});

		$('.price-sum em').text('￥' + sum.toFixed(2));
		
	}
// ##################################################################
// 删除功能：cart-item
	$('.p-action a').click(function () {
		// cart-item
		$(this).parents('.cart-item').remove();
		getSum();
	})

	$('.remove-batch').click(function () {

		$('.j-checkbox:checked').parents('.cart-item').remove();
		getSum();

	});

	$('.clear-all').click(function () {

		$('.cart-item').remove();
		getSum();

	});


});


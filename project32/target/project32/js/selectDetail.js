window.onload=function(){
    var fromStation = sessionStorage.getItem("fromStation");
    var toStation = sessionStorage.getItem("toStation");
    var goTime = sessionStorage.getItem("goTime");

    $.ajax({
        type: 'get',
        url: 'http://localhost:8080/project32/ticketsAvailable',
        dataType: "json",
        data:{
            fromStation:fromStation,
            toStation:toStation,
            goTime:goTime
        },
        success: function (res) {
            //$('#test').append(res);
            var str='<tr>\n' +
                '            <th>车次</th>\n' +
                '            <th>出发站</th>\n' +
                '            <th>到达站</th>\n' +
                '            <th>出发时间</th>\n' +
                '            <th>到达时间</th>\n' +
                '            <th>历时</th>\n' +
                '            <th>商务座</th>\n' +
                '            <th>一等座</th>\n' +
                '            <th>二等座</th>\n' +
                '            <th>高级软卧</th>\n' +
                '            <th>软卧一等卧</th>\n' +
                '            <th>动卧</th>\n' +
                '            <th>硬卧二等卧</th>\n' +
                '            <th>软座</th>\n' +
                '            <th>硬座</th>\n' +
                '            <th>无座</th>\n' +
                '            <th>预订</th>\n' +
                '        </tr>';
            $.each(res.result.list,function(i,ele){
                //console.log(ele);
                str+= `<tr>
                            <td>${ele.train_code}</td>
                            <td>${ele.from_station_name}</td>
                            <td>${ele.to_station_name}</td>
                            <td>${ele.start_time}</td>
                            <td>${ele.arrive_time}</td>
                            <td>${ele.run_time}</td>
                            
                            <td>${ele.swz_num}[￥${ele.swz_price}]</td>
                            <td>${ele.ydz_num}[￥${ele.ydz_price}]</td>
                            <td>${ele.edz_num}[￥${ele.edz_price}]</td>
                            <td>${ele.gjrw_num}[￥${ele.gjrws_price}]</td>
                            <td>${ele.ydw_num}[￥${ele.ydw_price}]</td>
                            
                            <td>${ele.dw_num}[￥${ele.dw_price})]</td>
                            <td>${ele.yw_num}[￥${ele.yw_price}]</td>
                            <td>${ele.rz_num}[￥${ele.rz_price}]</td>
                            <td>${ele.yz_num}[￥${ele.yz_price}]</td>
                            <td>${ele.wz_num}[￥${ele.wz_price}]</td>
                            
                            <td><div onclick="buyTicket('${ele.train_code}'
                                                        ,'${ele.from_station_code}'
                                                        ,'${ele.to_station_code}'
                                                        
                                                        ,'${ele.swz_num}'
                                                        ,'${ele.swz_price}'
                                                        ,'${ele.ydz_num}'
                                                        ,'${ele.ydz_price}'
                                                        ,'${ele.edz_num}'
                                                        ,'${ele.edz_price}'
                                                        )">预定</div></td>
                            
                            
                        </tr>
                        `;

            });

            $('#detail').append(str);


        }
    })
}


//点击订票
//传车次，出发站简码，到达站简码，出发日期(已在缓存)
function  buyTicket(checi,fromcode,tocode,swz_num,swz_price,ydz_num,ydz_price,edz_num,edz_price) {
    //车次信息存入缓存
    sessionStorage.setItem("checi",checi);
    sessionStorage.setItem("fromcode",fromcode);
    sessionStorage.setItem("tocode",tocode);

    sessionStorage.setItem("swz_num",swz_num);
    sessionStorage.setItem("swz_price",swz_price);

    sessionStorage.setItem("ydz_num",ydz_num);
    sessionStorage.setItem("ydz_price",ydz_price);

    sessionStorage.setItem("edz_num",edz_num);
    sessionStorage.setItem("edz_price",edz_price);


    //跳转页面
    window.location.href = "buyTicket.html";
}
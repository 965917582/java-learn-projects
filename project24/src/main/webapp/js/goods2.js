// 大量代码
$(function () {

// ###########################################################################
// 点击增加
// 获取内容，让内容加1，再设置给里面的内容
	// 添加事件
	$('.cart-item-list').on('click','.increment',function () {
		// 获取内容value值
		var n = $(this).siblings('.itxt').val();
		// 增加
		n++;
		// 设置给input
		$(this).siblings('.itxt').val(n);

		
		getSum();

	});
// ###############################################################################
// 点击减少
// 获取内容，让内容加1，再设置给里面的内容
	// 添加事件


	$('.cart-item-list').on('click','.decrement',function () {
		// 获取内容value值
		var n = $(this).siblings('.itxt').val();
		if (n == 1) {
			return;// 函数遇到return会立刻跳出
		}
		// 减少
		n--;
		// 设置给input
		$(this).siblings('.itxt').val(n);

		getSum();
		
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

	}



});


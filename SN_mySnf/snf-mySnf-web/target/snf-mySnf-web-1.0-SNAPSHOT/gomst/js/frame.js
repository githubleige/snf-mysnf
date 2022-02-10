//框架JS
;(function($,undefined){
	//左侧导航高度初始化
	var _sideHeight = sideBarHeight();
	_sideHeight = null;
	$(window).resize(function(){
		var _sideHeight =sideBarHeight();
		_sideHeight = null;
	});
	//左侧导航选择
	$(".mainmenu").on('click','dt',function(){
		$(this).parent().toggleClass('menu-active').siblings().removeClass('menu-active');
		var _sideHeight = sideBarHeight();
		$(".aftermarket-servicer-sidebar").height(_sideHeight);
		_sideHeight = null;
	});
	$(".mainmenu").on('click','dd',function(){
		$(this).parents(".mainmenu").find("dd").removeClass('childmenu-active');
		$(this).addClass('childmenu-active');
	});
	//返回顶部
	$(window).scroll(function(){
		var scrollHeight = $(this).scrollTop(),
			$elem = $(".aside-returntop");
		if(scrollHeight > 0){
			$elem.show();
			$elem.bind('click', function(){
				$(window).scrollTop("0");
			});
		}
	});
})(jQuery,window);


function sideBarHeight(){
	$(".aftermarket-servicer-content").css('height','auto');
	var	_thisWindowHeight = $(window).height() - 60,
		_thisRightBodyHeight = $(".aftermarket-servicer-content").height() + 100,
		_thisLeftBarHeight = $(".mainmenu").height() + 60,
		_thisMenuHeight = $('.newMenu').height();
	var _max = Math.max(_thisWindowHeight,_thisRightBodyHeight,_thisLeftBarHeight,_thisMenuHeight);
	$(".aftermarket-servicer-sidebar").height(_max);
	$('.aftermarket-servicer-content').height(_max -100);
}

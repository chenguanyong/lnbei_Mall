/**
 * 前端通用JS方法
 * Copyright (c) 2019 lnbei
 */
(function ($) {
    $.extend({
    	common:{
    		Sidebar:function (){
    			
    					// debugger;
    						if(!$('#wst-categorys')[0])return;
    						
    						if(!$('#wst-categorys').hasClass('j-index')){
    							$. common. dropDownLayer("#wst-categorys",".j-cate-dd");
    						}
    						$(".dd-inner").children(".item").hover(function() { //一级导航悬浮
    							
    							// debugger;
    						$('.categeMenuImg').lazyload({ effect: "fadeIn",failurelimit : 10,skip_invisible : false,threshold: 100});//默认图片
    							$(this).parent().find('.over-cat').show();

    					        $(this).addClass("hover").siblings(".item").removeClass("hover");
    					        var index = $(this).index();
    					        $(".dorpdown-layer").children(".item-sub").hide();
    					        $(".dorpdown-layer").children(".item-sub").eq(index).show();

    					        var start = $('.j-cate-dt').offset().top;
    					        var obj = $('#index_menus_sub');
    					        var sh = document.documentElement.scrollTop || document.body.scrollTop; // 滚动条距离顶部高度
    					        if(sh>start+36){
    						            var start = sh-start;
    					        }else{
    					        	var start = 0;
    					        }
    					        //obj.stop().animate({ "top": start });
    					        obj.css('top',start);


    					    },function(){
    					    	$(this).parent().find('.over-cat').hide();
    					    });



    					    $('.over-cat-icon').parent().mouseover(function(){
    					    	 $(this).find('.over-cat-icon').addClass('over-cat-icon-hover');
    					    });
    					     $('.over-cat-icon').parent().mouseout(function(){
    					    	$(this).find('.over-cat-icon').removeClass('over-cat-icon-hover');
    					    });

    					    $(".dd-inner").children(".item").mouseover(function() {

    					    	$('.dd-inner').find('.over-cat').show();

    					        var iCon = $(this).attr('id');
    					        $('.'+iCon).addClass(iCon+'-hover');
    					    });
    					    $(".dd-inner").children(".item").mouseout(function() {

    					    	$('.dd-inner').find('.over-cat').hide();

    					        var iCon = $(this).attr('id');
    					        $('.'+iCon).removeClass(iCon+'-hover');
    					    });

    					    $("#index_menus_sub").hover(function(){
    					    	$('.dd-inner').find('.over-cat').show();
    					    	$(this).show();
    					    },function(){
    					    	$(this).hide();
    					    	$('.dd-inner').find('.over-cat').hide();
    					    });
    					    $(".dd-inner").hover(function() { //整个导航菜单悬浮，是否显示二级导航到出厂
    					        $("#index_menus_sub").show();

    					    }, function() {
    					        $("#index_menus_sub").hide();
    					        $('.item').removeClass("hover");
    					    })
    					    $("#index_menus_sub").children(".item-sub").hover(function() { //二级导航悬浮
    					        var index = $(this).index();
    					        $(".dd-inner").children(".item").eq(index).addClass("hover");
    					        $("#index_menus_sub").show();
    					        var i = index+1;
    					        $('.cat-icon-'+i).addClass('cat-icon-'+i+'-hover');
    					    }, function() {
    					        $("#index_menus_sub").hide();
    					        $(".dd-inner").children(".item").removeClass("hover");
    					        var index = $(this).index();
    					        var i = index+1;
    					        $('.cat-icon-'+i).removeClass('cat-icon-'+i+'-hover');

    					    });
    					    
    					    $('.fore2').hover(function(){
    						$(this).children('dt').css('background-color','#ff6a53');
    						},function(){
    							$(this).children('dt').css('background-color','');
    						});
    					
    			
    		},
    		dropDownLayer:function (dropdown,layer){
    			
    				$(dropdown).hover(function () {
    			        $(this).find(layer).show();
    			    }, function () {
    			    	$(this).find(layer).hide();
    			    });
    				$(layer).hover(function () {
    					$(this).find(layer).show();
    			    }, function () {
    			    	$(this).find(layer).hide();
    			    });
    			
    		},
    		loadImg:function (_target){
    			$(_target).lazyload({ failurelimit : 10,skip_invisible : false,threshold: 200,placeholder:""});
    		},
    		/**
    		 * 轮播图
    		 */
    		slides:function (objId){
    			
    					var slide = $(objId), li = slide.find("li");
    					var slidecontrols = $(objId+'-controls').eq(0), 
    						span = slidecontrols.find("span");
    					var index = 1, _self = null;
    					span.bind("mouseover", function() {
    						_self = $(this);
    						index = span.index(_self);
    						span.removeClass("curr");
    						span.eq(index).addClass("curr");
    						li.addClass("hide");
    						li.css("z-index", -1);
    						li.css("display", "none");
    						li.eq(index).css("display", "");
    						li.eq(index).css("z-index", 1);
    						li.eq(index).removeClass("hide");
    						clearInterval(timer);
    					});
    					var timer = setInterval(function() {
    						span.removeClass("curr");
    						span.eq(index).addClass("curr");
    						li.addClass("hide");
    						li.css("z-index", -1);
    						li.css("display", "none");
    						li.eq(index).fadeToggle(500);
    						li.eq(index).css("z-index", 1);
    						li.eq(index).removeClass("hide");
    						index++;
    						if (index >= span.length)
    							index = 0;
    					}, 4000);
    					span.bind("mouseout", function() {
    						index++;
    						if (index >= span.length)
    								index = 0;
    						timer = setInterval(function() {
    							span.removeClass("curr");
    							span.eq(index).addClass("curr");
    							li.addClass("hide");
    							li.css("z-index", -1);
    							li.css("display", "none");
    							li.eq(index).fadeToggle(500);
    							li.eq(index).css("z-index", 1);
    							li.eq(index).removeClass("hide");
    							index++;
    							if (index >= span.length)
    								index = 0;
    						}, 4000);
    					});
    				
    		}
    	}
    
    });
})(jQuery);
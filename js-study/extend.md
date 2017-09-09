
##### jQuery.extend & jQuery.fn.extend
```
ref from :
http://www.cnblogs.com/wyjgreat/archive/2011/07/19/2110754.html
```
```
// example
jQuery.extend(object); 为扩展jQuery类本身.为类添加新的方法。
jQuery.fn.extend(object);给jQuery对象添加方法

$.extend({   
　　add:function(a,b){return a+b;}   
});
$.add(3,4); //return 7  
--------------------------------------------------------------
$.fn.extend({

     alertWhileClick:function(){        

         $(this).click(function(){        

              alert($(this).val());        
          });        

      }        

});        
$(“#input1″).alertWhileClick(); //页面上为：<input id=”input1″ type=”text”/>    
```

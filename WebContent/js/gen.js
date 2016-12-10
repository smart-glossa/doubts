/**
 * 
 */
$(document).ready(function(){
        $("input[type='button']").click(function(){
            var radioValue = $("input[name='gender']:checked").val();
           if(radioValue){
               alert("Your are a - " + radioValue);
            } //http://localhost:8080/lkjlkj/gen?operation=add&gender=male
	var url = "/lkjlkj/gen?operation=add&gender="+ radioValue ;
	$.ajax({
		url:url,
		type:'POST'
	})
	.done(function(result){
		alert(result);
	})
	.fail(function(result){
		alert(result);
	})
	
});
});
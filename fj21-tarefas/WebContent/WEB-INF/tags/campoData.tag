<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="id" required="true"%>
<%@ attribute name="data" required="false"%>
<input type="text" id="${id}" name="${id}" value="${data}"/>
<script>
// 	$("#${id}").datepicker({dateFormat: 'dd/mm/yy'});
	$("#${id}").datepicker({changeMonth: true, changeYear: true});
</script>
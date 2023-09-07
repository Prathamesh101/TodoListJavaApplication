    <%@ include file="common/header.jspf" %>
    <%@ include file="common/navigation.jspf" %>
	<div class= "container">
	<h1>Add todos</h1>
    <form:form method="post" modelAttribute="todo">
        <fieldset>
         <form:label path="description">Description: </form:label>
         <form:input type="text" path="description" cssClass="mb-3" required="required"/>
         <form:errors path="description" cssClass="text-warning"/>
        </fieldset>
        <fieldset>
         <form:label path="targetDate">Target Date: </form:label>
         <form:input type="text" cssClass="mb-3" path="targetDate" required="required"/>
        </fieldset>
        <form:input type="hidden" path="id"/>
        <form:input type="hidden" path="done"/>
        <button type="submit" cssClass="mb-3" value="Submit" class="btn btn-primary"/>
    </form:form>
	</div>
        <script type="text/Script">
        $('#targetDate').datepicker({
            format: 'yyyy-mm-dd'
        });
        </script>
    <%@ include file="common/footer.jspf" %>

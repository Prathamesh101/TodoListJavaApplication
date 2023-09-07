    <%@ include file="common/header.jspf" %>
    <%@ include file="common/navigation.jspf" %>
		<div class= "container">

		<h1 class="pd-2">Your Todos are: </h1>

		<hr>

		<table class="table">
		  <thead>
            <tr>
              <th scope="col">#</th>
              <th scope="col">Description</th>
              <th scope="col">Date</th>
              <th scope="col">Done</th>
              <th scope="col"></th>
              <th scope="col"></th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${todos}" var= "todo">
            <tr>
            <th scope="row">${todo.id}</th>
            <td>${todo.description}</td>
            <td>${todo.targetDate}</td>
            <td>${todo.done}</td>
            <td><a class="btn btn-warning" href="delete-todo?id=${todo.id}">Delete</a></td>
            <td><a class="btn btn-success" href="update-todo?id=${todo.id}">Update</a></td>
            </tr>
            </c:forEach>
          </tbody>

		</table>

		<a type="button" class="btn btn-success" href = "/add-todo">Add</a>

		</div>
    <%@ include file="common/footer.jspf" %>

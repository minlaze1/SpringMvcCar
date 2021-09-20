<%@include file="common/header.jspf" %>


<p><font color="red">${errorMessage}</font></p>

<form action="/login" method="post">
            <label for="usr">UserName</label>
            <input type="text" name="username" required>
            <label for="pass">Password</label>
            <input type="password" name="password" required>
            <input type="submit">
</form>
            
<%@include file="common/footer.jspf" %>
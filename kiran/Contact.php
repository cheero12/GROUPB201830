<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Untitled Document</title>
<link rel="stylesheet" type="text/css" href="includes/contact.css" />
</head>

<body>

<?php
	include('menu.php');
?>
<div id = "slideshow-container">
<h> If you are interested in:
.publishing your origami artwork.</h>

<h1> You'll need to fill out all the fields in order me to send me an email.
 Please double-check your email address before clicking the Send message button. Thanks!</h1>
<form method ="post" action = "contactprocess.php">
<br>
Your Name*:<input type = "text" name ="yourname" size = "10"><br><br>
Your e-mail address*: <input type = "text" name ="emailaddress" size = "10"><br><br>
Please retype your e-mail address* :<input type = "text" name = "retypeemail" size = "10"><br><br>
Subject: <input type = "text" name = "subject" size = "10"><br><br><br> 

<input type = "submit">
</form>
</div>
<footer>Your company name.</footer>
</div>


</body>
</body>
</html>

<html>
<body>


<?php
	include('menu.php');
?>

<div id = "slideshow-container"> 
 <div id="table">
<?php


// Report all errors except E_NOTICE
error_reporting(E_ALL & ~E_NOTICE);


$connid = @mysql_connect ('localhost', "root", "") or die("Connection to the DBMS server failed");
mysql_select_db ("kiran", $connid);
$result = mysql_query("SELECT * FROM plants");

while ($a = mysql_fetch_array($result)) { 

	echo $a['Name'];
	echo "&nbsp &nbsp";
	


	?>
	<img src="images/plants/<?php echo $a['img']?>" width="150" height="150">
 	<a href="<?php	echo $a['url']?>">Learn Now </a>
    </br>
    <?php
	};
	mysql_close ($connid);
	
	?>





</div>
        
</div>      





<footer>Your company name.</footer>
</div>


</body>
</html>
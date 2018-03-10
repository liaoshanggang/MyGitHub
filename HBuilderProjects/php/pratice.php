<?php
@header('Content-type: text/html;charset=UTF-8');
?>
<form method=POST>
   <input type="text" name="tireqty">     <input type="text" name="oilqty">
   <input type="text" name="sparkqty">   <input type="submit" value="Submit">
</form>
<?php
  foreach ($_POST as $key => $value) {
  	
    echo "$key";
    echo "====";
    $$key = $value;
    echo "$$key";
    echo "====";
    echo "${$key}";
    echo "hello2<br>";
  }
//tireqty====$tireqty====111hello2
//oilqty====$oilqty====222hello2
//sparkqty====$sparkqty====333hello2
//sparkqty333222111
  echo $key; //sparkqty   
  echo $sparkqty;    
  echo $oilqty;    
  echo $tireqty;
  echo '这是第 " '  . __LINE__ . ' " 行';
  echo "<br>";
  echo '该文件位于 " '  . __FILE__ . ' " ';
  echo "<br>";
  echo '该文件位于 " '  . __DIR__ . ' " ';
  echo "<br>";
?>
<form method="post" action="">
<label>Tags</label>
<input type="text" name="tags[]"/>
<input type="text" name="tags[]"/>
<input type="text" name="tags[]"/>
<input type="text" name="tags[]"/>
<input type="text" name="tags[]"/>
<input type="submit" value="submit">
</form>
</html>
<?php
$postedtags = $_POST['tags'];
foreach ($postedtags as $tag){
  echo "<br />$tag";
}
?>
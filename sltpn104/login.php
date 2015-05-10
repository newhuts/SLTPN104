<?php
// array for JSON response
$response = array();
// include db connect class
require_once __DIR__ . '/db_connect.php';
// connecting to db
$db = new DB_CONNECT();
// check for post data
if (isset($_POST["username"])&& isset($_POST["password"])) {
    $us = $_POST['username'];
    $pw = $_POST['password'];
    // get a product from products table
    $result = mysql_query("SELECT * FROM admin WHERE username = '$us' and password = '$pw' " );
    if (!empty($result)) {
        // check for empty result
        if (mysql_num_rows($result) > 0) {
            $result = mysql_fetch_array($result);
            $mahasiswa = array();
            $mahasiswa["id"] = $result["id"];
            $mahasiswa["username"] = $result["username"];
            $mahasiswa["password"] = $result["password"];
            $mahasiswa["akses"] = $result["akses"];
            $response["login"] = $mahasiswa;
            $oke["d"] = $response;

            echo json_encode($oke);



        } else {
            $response["reason"] = "username atau password tidak cocok";
            $oke["e"] = $response;
            echo json_encode($oke);

        }
    } else {
        // no product found
        $response["reason"] = "username atau password tidak cocok";
        $oke["e"] = $response;
        echo json_encode($oke);
    }
} else {
    $response["reason"] = "akses ditolak";
            $oke["e"] = $response;
            echo json_encode($oke);
}
?>
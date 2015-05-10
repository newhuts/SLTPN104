  <?php
// array for JSON response
$response = array();
// check for required fields
if (isset($_GET['akses'])) {
    $akses = $_GET['akses'];
    // include db connect class
    require_once __DIR__ . '/db_connect.php';
    // connecting to db
    $db = new DB_CONNECT();
    // mysql inserting a new row

    if ($akses == "admin") {
        $result = mysql_query("SELECT * FROM pelajaran");
        // check if row inserted or not
        if (mysql_num_rows($result) > 0) {
            // looping through all results
            // products node
            $response["pelajaran"] = array();
            while ($row = mysql_fetch_array($result)) {
                // temp user array
                $permintaan = array();
                    $permintaan["kd_pel"] = $row["kd_pel"];
                    $permintaan["hari"] = $row["hari"];
                    $permintaan["jam"] = $row["jam"];
                    $permintaan["kls"] = $row["kls"];
                    $permintaan["semester"] = $row["semester"];
                    $permintaan["nm_pel"] = $row["nm_pel"];
                // push single product into final response array
                array_push($response["pelajaran"], $permintaan);
            }
            // success
            // echoing JSON response
            // $response["siswa"] = $response  ;
            $oke["d"] = $response;
            echo json_encode($oke);

            // echo json_encode($response);
        } else {
            // no products found
            $response["reason"] = "(1) oops! tidak ada pelajaran !";
            $oke["e"] = $response;
            echo json_encode($oke);
        }
    }else {
        $response["reason"] = "(3) oops! akses ditolak !";
        $oke["e"] = $response;
        echo json_encode($oke);
    }
    
} else {
    $response["reason"] = "(2) oops! ada yang salah !";
    $oke["e"] = $response;
    echo json_encode($oke);
}
?>
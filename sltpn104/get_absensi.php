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
        $result = mysql_query("SELECT * FROM absensi");
        // check if row inserted or not
        if (mysql_num_rows($result) > 0) {
            // looping through all results
            // products node
            $response["absensi"] = array();
            while ($row = mysql_fetch_array($result)) {
                // temp user array
                $permintaan = array();
                    $permintaan["id_absen"] = $row["id_absen"];
                    $permintaan["tgl_msk"] = $row["tgl_msk"];
                    $permintaan["jam_msk"] = $row["jam_msk"];
                    $permintaan["jam_klr"] = $row["jam_klr"];
                    $permintaan["status"] = $row["status"];
                    $permintaan["ket_absen"] = $row["ket_absen"];
                // push single product into final response array
                array_push($response["absensi"], $permintaan);
            }
            // success
            // echoing JSON response
            // $response["siswa"] = $response  ;
            $oke["d"] = $response;
            echo json_encode($oke);

            // echo json_encode($response);
        } else {
            // no products found
        $response["reason"] = "(1) oops! tidak ada absensi !";
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
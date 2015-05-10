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
        $result = mysql_query("SELECT * FROM guru");
        // check if row inserted or not
        if (mysql_num_rows($result) > 0) {
            // looping through all results
            // products node
            $response["guru"] = array();
            while ($row = mysql_fetch_array($result)) {
                // temp user array
                $permintaan = array();
                    $permintaan["nip"] = $row["nip"];
                    $permintaan["nm_guru"] = $row["nm_guru"];
                    $permintaan["jns_klmn_guru"] = $row["jns_klmn_guru"];
                    $permintaan["temp_lhr_guru"] = $row["temp_lhr_guru"];
                    $permintaan["tgl_lhr_guru"] = $row["tgl_lhr_guru"];
                    $permintaan["almt_guru"] = $row["almt_guru"];
                    $permintaan["agm_guru"] = $row["agm_guru"];
                    $permintaan["status_peg"] = $row["status_peg"];
                    $permintaan["thn_masuk"] = $row["thn_masuk"];
                    $permintaan["tgs_mgjr_mp"] = $row["tgs_mgjr_mp"];
                    $permintaan["tlp_guru"] = $row["tlp_guru"];
                // push single product into final response array
                array_push($response["guru"], $permintaan);
            }
            // success
            // echoing JSON response
            // $response["siswa"] = $response  ;
            $oke["d"] = $response;
            echo json_encode($oke);

            // echo json_encode($response);
        } else {
            // no products found
        $response["reason"] = "(1) oops! tidak ada guru !";
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
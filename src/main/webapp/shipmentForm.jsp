<!DOCTYPE html>
<html>
<head>
    <title>Create Shipment</title>
</head>
<body>
    <h2>Create Shipment</h2>
    <form action="create_shipment" method="post">
        <label for="method">Shipment Method:</label>
        <input type="text" id="method" name="method"><br><br>
        
        <label for="date">Shipment Date:</label>
        <input type="date" id="date" name="date"><br><br>
        
        <label for="address">Shipping Address:</label>
        <input type="text" id="address" name="address"><br><br>
        
        <input type="submit" value="Create Shipment">
    </form>
</body>
</html>

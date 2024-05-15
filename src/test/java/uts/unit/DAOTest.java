package uts.unit;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uts.isd.model.Shipment;
import uts.isd.model.dao.DBConnector;
import uts.isd.model.dao.ShipmentDAO;

public class DAOTest {

    private DBConnector connector;
    private Connection conn;
    private ShipmentDAO shipmentDAO;

    
}

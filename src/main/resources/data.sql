-- Inserting test data into glpi_plugin_genericobject_boardtypes table
INSERT INTO glpi_plugin_genericobject_boardtypes (name, comment, date_mod, date_creation)
VALUES
('CRB', 'Board type CRB.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('EVB', 'Board type EVB.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Inserting test data into glpi_plugin_genericobject_boardmodels table
INSERT INTO glpi_plugin_genericobject_boardmodels (name, comment, date_mod, date_creation)
VALUES
('CRB Model 1', 'Sub model of CRB.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('CRB Model 2', 'Another sub model of CRB.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('CRB Model 3', 'A third sub model of CRB.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('EVB Model 1', 'Sub model of EVB.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('EVB Model 2', 'Another sub model of EVB.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Inserting test data into glpi_states table
INSERT INTO glpi_states (name, entities_id, is_recursive, comment, states_id, completename, level, ancestors_cache, sons_cache, is_visible_computer, is_visible_monitor, is_visible_networkequipment, is_visible_peripheral, is_visible_phone, is_visible_printer, is_visible_softwareversion, is_visible_softwarelicense, is_visible_line, is_visible_certificate, is_visible_rack, is_visible_passivedcequipment, is_visible_enclosure, is_visible_pdu, is_visible_cluster, is_visible_contract, is_visible_appliance, is_visible_databaseinstance, is_visible_cable, date_mod, date_creation)
VALUES
('Active', 1, true, 'Active state', 1, 'Active', 1, '', '', true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Inactive', 1, true, 'Inactive state', 2, 'Inactive', 1, '', '', false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Under Maintenance', 1, true, 'Under maintenance state', 3, 'Under Maintenance', 1, '', '', false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Inserting test data into glpi_plugin_genericobject_boards table
INSERT INTO glpi_plugin_genericobject_boards (is_template, template_name, is_deleted, entities_id, is_recursive, name, comment, is_helpdesk_visible, date_mod, date_creation, groups_id, locations_id, manufacturers_id, users_id_tech, otherserial, plugin_genericobject_boardmodels_id, plugin_genericobject_boardtypes_id, serial, states_id, users_id)
VALUES
(false, 'Standard Board', false, 1, false, 'Test CRB Board 1', 'This is a test CRB board.', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1, 1, 1, 1, '123456', 1, 1, 'ABC123', 1, 1),
(false, 'Standard Board', false, 1, false, 'Test CRB Board 2', 'This is another test CRB board.', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1, 1, 1, 1, '654321', 2, 1, 'XYZ456', 1, 1),
(false, 'Standard Board', false, 1, false, 'Test CRB Board 3', 'This is a third test CRB board.', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1, 1, 1, 1, '789012', 3, 1, 'DEF789', 2, 2),
(false, 'Standard Board', false, 1, false, 'Test EVB Board 1', 'This is a test board of EVB type.', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1, 1, 1, 1, '111111', 4, 2, 'LMN789', 2, 2),
(false, 'Standard Board', false, 1, false, 'Test EVB Board 2', 'This is another test board of EVB type.', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1, 1, 1, 1, '222222', 5, 2, 'OPQ123', 3, 3),
(false, 'Standard Board', false, 1, false, 'Test EVB Board 3', 'This is a third test board of EVB type.', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1, 1, 1, 1, '333333', 6, 2, 'RST456', 3, 3);

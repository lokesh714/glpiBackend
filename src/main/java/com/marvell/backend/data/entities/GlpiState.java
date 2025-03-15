package com.marvell.backend.data.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;


@Entity
@Table(name = "glpi_states")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GlpiState {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Long entitiesId;
    private Boolean isRecursive;
    private String comment;
    private Long statesId;
    private String completename;
    private Integer level;
    private String ancestorsCache;
    private String sonsCache;
    private Boolean isVisibleComputer;
    private Boolean isVisibleMonitor;
    private Boolean isVisibleNetworkequipment;
    private Boolean isVisiblePeripheral;
    private Boolean isVisiblePhone;
    private Boolean isVisiblePrinter;
    private Boolean isVisibleSoftwareversion;
    private Boolean isVisibleSoftwarelicense;
    private Boolean isVisibleLine;
    private Boolean isVisibleCertificate;
    private Boolean isVisibleRack;
    private Boolean isVisiblePassivedcequipment;
    private Boolean isVisibleEnclosure;
    private Boolean isVisiblePdu;
    private Boolean isVisibleCluster;
    private Boolean isVisibleContract;
    private Boolean isVisibleAppliance;
    private Boolean isVisibleDatabaseinstance;
    private Boolean isVisibleCable;
    private Timestamp dateMod;
    private Timestamp dateCreation;

    // Getters and Setters
}

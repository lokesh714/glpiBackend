package com.marvell.backend.data.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "glpi_plugin_genericobject_boards")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "is_template", nullable = false)
    private boolean isTemplate;

    @Column(name = "template_name", nullable = false)
    private String templateName;

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted;

    @Column(name = "entities_id", nullable = false)
    private int entitiesId;

    @Column(name = "is_recursive", nullable = false)
    private boolean isRecursive;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "comment", columnDefinition = "TEXT")
    private String comment;

    @Column(name = "is_helpdesk_visible", nullable = false)
    private boolean isHelpdeskVisible;

    @Column(name = "date_mod")
    private Timestamp dateMod;

    @Column(name = "date_creation")
    private Timestamp dateCreation;

    @Column(name = "groups_id", nullable = false)
    private int groupsId;

    @Column(name = "locations_id", nullable = false)
    private int locationsId;

    @Column(name = "manufacturers_id", nullable = false)
    private int manufacturersId;

    @Column(name = "users_id_tech", nullable = false)
    private int usersIdTech;

    @Column(name = "otherserial", nullable = false)
    private String otherSerial;

    @Column(name = "plugin_genericobject_boardmodels_id", nullable = false)
    private int pluginGenericobjectBoardmodelsId;

    @Column(name = "plugin_genericobject_boardtypes_id", nullable = false)
    private int pluginGenericobjectBoardtypesId;

    @Column(name = "serial", nullable = false)
    private String serial;

    @Column(name = "states_id", nullable = false)
    private int statesId;

    @Column(name = "users_id", nullable = false)
    private int usersId;
}

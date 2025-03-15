package com.marvell.backend.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardStateDTO {

    private String boardName;

    private String boardStatus;
    
}

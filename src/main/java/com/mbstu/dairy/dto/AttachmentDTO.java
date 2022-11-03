package com.mbstu.dairy.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Author: Md. Tanver Ahammed,
 * ICT, MBSTU
 * */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AttachmentDTO implements Serializable {

    private Long id;

    private String attachmentPath;

    private String attachmentName;

    private String attachmentFileName;

    private String attachmentType;

}

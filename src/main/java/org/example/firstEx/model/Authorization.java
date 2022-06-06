package org.example.firstEx.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_authorization")
@Setter
@Getter
public class Authorization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private EPermission permission;
    private String source;
    private Long userId;
    private Long groupId;
    private Boolean active;
    @CreatedDate
    private Date createDate;
    @CreatedBy
    private String createBy;
    @CreatedDate
    private Date updateDate;
    @CreatedBy
    private String updateBy;
}
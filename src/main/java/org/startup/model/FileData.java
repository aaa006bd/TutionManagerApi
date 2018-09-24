package org.startup.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Abdullah Al Amin on 9/17/2018.
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class FileData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "fileData_id")
    @Getter@Setter
    private long id;

    @OneToOne(mappedBy = "fileData")
    @Getter@Setter
    private Teacher owner;
    @Lob
    @Getter
    @Setter
    private byte[] pdf;

    @Lob
    @Getter@Setter
    private byte[] image;
}

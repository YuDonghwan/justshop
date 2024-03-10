package dong.shop.domain.cmm;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Entity
@SequenceGenerator(
        name = "CMM_FILE_SEQ_GEN",
        sequenceName = "CMM_FILE_SEQ",
        initialValue = 1,
        allocationSize = 1
)
public class CmmFile {

    @Id @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "CMM_FILE_SEQ_GEN"
    )
    private Long id;
    private String realFileName;
    private String localFileName;
    private Long size;
    private String fileUrl;
    private String ext;
    private LocalDateTime regDate;
    private String fileCd;

    public CmmFile() {
    }

    public CmmFile(Long fileId,String ext, String realFileName, String localFileName, Long size, String fileUrl, LocalDateTime regDate, String fileCd) {

        this.id = id;
        this.realFileName = realFileName;
        this.localFileName = localFileName;
        this.size = size;
        this.fileUrl = fileUrl;
        this.regDate = regDate;
        this.fileCd = fileCd;
        this.ext = ext;
    }
}

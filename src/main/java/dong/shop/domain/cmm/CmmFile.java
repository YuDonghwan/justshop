package dong.shop.domain.cmm;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CmmFile {

    private Long fileId;
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

        this.fileId = fileId;
        this.realFileName = realFileName;
        this.localFileName = localFileName;
        this.size = size;
        this.fileUrl = fileUrl;
        this.regDate = regDate;
        this.fileCd = fileCd;
        this.ext = ext;
    }
}

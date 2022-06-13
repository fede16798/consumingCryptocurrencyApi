package consumingApis.consumingApis.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class BlockchainsDTO {
    private String id;
    private String chan_identifier;
    private String name;
    private String shortname;
}

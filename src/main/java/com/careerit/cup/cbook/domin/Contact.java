package com.careerit.cup.cbook.domin;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Contact {
    @Id
    private String id;
    private String name;
    private String mobile;
}

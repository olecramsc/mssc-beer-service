package guru.springframework.msscbeerservice.brewery.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BeerDto implements Serializable {

  @Null private UUID id;
  @Null private Integer version;

  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ", shape = JsonFormat.Shape.STRING)
  @Null
  private OffsetDateTime createdDate;

  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ", shape = JsonFormat.Shape.STRING)
  @Null
  private OffsetDateTime lastModifiedDate;

  @NotBlank
  @Size(min = 3, max = 100)
  private String beerName;

  @NotNull private BeerStyleEnum beerStyle;
  @NotNull @Positive private Long upc;

  @JsonFormat(shape = JsonFormat.Shape.STRING)
  @NotNull
  @Positive
  private BigDecimal price;

  private Integer quantityOnHand;
}

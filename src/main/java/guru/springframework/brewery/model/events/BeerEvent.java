package guru.springframework.brewery.model.events;

import guru.springframework.brewery.model.BeerDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BeerEvent implements Serializable {

  static final long serialVersionUID = -4880347746997962298L;

  private BeerDto beerDto;
}
package br.com.alelo.consumer.consumerpat.model;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@Entity
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Consumer implements Serializable{

    /**
	 * @author raul.candido
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    private String name;
    
    private Integer documentNumber;
    
    private LocalDate birthDate;

	@OneToOne(cascade = CascadeType.ALL)
    private Contact contact;

	@OneToOne(cascade = CascadeType.ALL)
	private Adress adress;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Card> cards;

}

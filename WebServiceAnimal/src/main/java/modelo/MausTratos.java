package modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: MausTratos
 *
 */
@Entity
public class MausTratos implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idMausTratos")
	private Long id;
	// private static final long serialVersionUID = 1L;
	private String endereco;
	private String cidade;
	private String infoContato;
	private Integer latitude;
	private Integer longitude;
	private String descricao;

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getInfoContato() {
		return infoContato;
	}

	public void setInfoContato(String infoContato) {
		this.infoContato = infoContato;
	}

	public Integer getLatitude() {
		return latitude;
	}

	public void setLatitude(Integer latitude) {
		this.latitude = latitude;
	}

	public Integer getLongitude() {
		return longitude;
	}

	public void setLongitude(Integer longitude) {
		this.longitude = longitude;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public MausTratos() {
		super();
	}

}

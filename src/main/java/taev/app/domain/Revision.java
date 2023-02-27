package taev.app.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "revision")
public class Revision {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "filtro")
	private int filtro;

	@Column(name = "aceite")
	private int aceite;

	@Column(name = "frenos")
	private int frenos;

	@ManyToOne
	@JoinColumn (name = "coche_id")
	private Coche coche;

	public boolean isClear() {
		if (filtro == 0 && aceite == 0 && frenos == 0) {
			return true;
		}
		return false;
	}
}

package service;

import java.util.Date;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import dao.DaoGenerico;
import modelo.Adocao;
import modelo.MausTratos;

@Path("/WebService")
@ApplicationPath("/resource")
public class AnimalService extends Application {

	@POST
	@Path("/addMausTratos")
	public Response addMausTratos(@FormParam("cidade") String cidade, @FormParam("descricao") String descricao,
			@FormParam("endereco") String endereco, @FormParam("infoContato") String infoContato,
			@FormParam("latitude") Integer latitude, @FormParam("longitude") Integer longitude) {

		MausTratos maustratos = new MausTratos();
		maustratos.setCidade(cidade);
		maustratos.setDescricao(descricao);
		maustratos.setEndereco(endereco);
		maustratos.setInfoContato(infoContato);
		maustratos.setLatitude(latitude);
		maustratos.setLongitude(longitude);

		DaoGenerico dao = new DaoGenerico();
		dao.inserir(maustratos);

		return Response.status(200).entity("Denúncia salva com sucesso").build();

	}	
	
	@GET
	@Path("/hello")
	public String getHello(){
		return "Hello Web Service";
	}
	
	@POST
	@Path("/addAdocao")
	public Response addAdocao(@FormParam("anunciante") String anunciante, 
			@FormParam("certificado") boolean certificado, @FormParam("cidade") String cidade,
			@FormParam("cpf") String cpf, @FormParam("dataAnuncio") Date dataAnuncio, 
			@FormParam("descricacao") String descricao, @FormParam("especie") String especie,
			@FormParam("estado") String estado, @FormParam("fone") String fone, 
			@FormParam("nome") String nome, @FormParam("observacao") String observacao,
			@FormParam("porte") char porte, @FormParam("raca") String raca,
			@FormParam("sexo") String sexo) {

		Adocao adocao = new Adocao();
		adocao.setAnunciante(anunciante);
		adocao.setCertificado(certificado);
		adocao.setCidade(cidade);
		adocao.setCpf(cpf);
		adocao.setDataAnuncio(dataAnuncio);
		adocao.setDescricao(descricao);
		adocao.setEspecie(especie);
		adocao.setEstado(estado);
		adocao.setFone(fone);
		adocao.setNome(nome);
		adocao.setObservacao(observacao);
		adocao.setPorte(porte);
		adocao.setRaca(raca);
		adocao.setSexo(sexo);
		
		DaoGenerico dao = new DaoGenerico();
		dao.inserir(adocao);

		return Response.status(200).entity("Adoção salva com sucesso").build();

	}
}

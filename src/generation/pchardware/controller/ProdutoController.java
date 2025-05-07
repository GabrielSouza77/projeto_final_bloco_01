package generation.pchardware.controller;

import java.util.ArrayList;
import java.util.Optional;

import generation.pchardware.model.Produto;
import generation.pchardware.repository.ProdutoRepository;

public class ProdutoController implements ProdutoRepository {

	private ArrayList<Produto> listaProdutos = new ArrayList<Produto>();

	int id = 0;

	@Override
	public void procurarPorId(int id) {

		Optional<Produto> produto = buscarNaCollection(id);

		if (produto.isPresent())
			produto.get().visualizar();
		else
			System.out.printf("\nO Produto número %d não foi encontrado", id);

	}
	
	@Override
	public void procurarPorMarca(String marca) {
	    // Remove espaços em branco no início e fim da marca digitada
	    String marcaBusca = marca.trim();

	    var produtosEncontrados = listaProdutos.stream()
	        .filter(produto -> produto.getMarca().trim().equalsIgnoreCase(marcaBusca))
	        .toList();

	    if (produtosEncontrados.isEmpty()) {
	        System.out.println("\nNenhum produto encontrado com a marca: " + marcaBusca);
	    } else {
	        produtosEncontrados.forEach(Produto::visualizar);
	    }
	}

	@Override
	public void listarTodos() {
	    if (listaProdutos.isEmpty()) {
	        System.out.println("Não existe nenhum produto cadastrado.");
	    } else {
	        for (var produto : listaProdutos) {
	            produto.visualizar();
	        }
	    }
	}

	@Override
	public void cadastrar(Produto produto) {
		listaProdutos.add(produto);
		System.out.println("O Produto foi criado com sucesso!");
	}

	@Override
	public void atualizar(Produto produto) {
		Optional<Produto> buscaProduto = buscarNaCollection(produto.getId());

		if (buscaProduto.isPresent()) {
			listaProdutos.set(listaProdutos.indexOf(buscaProduto.get()), produto);
			System.out.printf("\nO Produto ID %d foi atualizado com sucesso!", produto.getId());
		} else
			System.out.printf("\nO Produto ID %d não foi encontrado", produto.getId());

	}

	@Override
	public void deletar(int id) {
		Optional<Produto> produto = buscarNaCollection(id);

		if (produto.isPresent()) {
			if (listaProdutos.remove(produto.get()) == true)
				System.out.printf("\nO Produto ID %d foi excluído com sucesso!", id);
		} else
			System.out.printf("\nO Produto ID %d não foi encontrado", id);

	}

	// Métodos Auxiliares

	public int gerarId() {
		return ++id;
	}

	public Optional<Produto> buscarNaCollection(int id) {
		for (var produto : listaProdutos) {
			if (produto.getId() == id)
				return Optional.of(produto);
		}

		return Optional.empty();
	}
}

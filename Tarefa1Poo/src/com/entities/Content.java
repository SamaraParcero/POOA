package com.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Content implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String titulo;
	private String subtitulo;
	private String corpo;
	private String autor;
	private List<Content> contents = new ArrayList<>();
	
	public Content() {
		
	}

	public Content(Long id, String titulo, String subtitulo, String corpo, String autor) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.subtitulo = subtitulo;
		this.corpo = corpo;
		this.autor = autor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSubtitulo() {
		return subtitulo;
	}

	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}

	public String getCorpo() {
		return corpo;
	}

	public void setCorpo(String corpo) {
		this.corpo = corpo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public List<Content> getContents() {
		return contents;
	}

	public void setContents(List<Content> contents) {
		this.contents = contents;
	}
	
	public void criarConteudo() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o título do conteúdo:");
        String titulo = scan.nextLine();
        System.out.println("Digite o subtítulo do conteúdo:");
        String subtitulo = scan.nextLine();
        System.out.println("Digite o autor do conteúdo:");
        String autor = scan.nextLine();
        System.out.println("Digite o conteúdo:");
        String conteudo = scan.nextLine();

        long id = contents.size() + 1;  
        Content novoConteudo = new Content(id, titulo, subtitulo, conteudo, autor);
        contents.add(novoConteudo);
        System.out.println("Conteúdo criado!");
    }

    public void listarConteudos() {
        if (contents.isEmpty()) {
            System.out.println("Nenhum conteúdo disponível.");
        } else {
            for (Content content : contents) {
                System.out.println("ID: " + content.getId());
                System.out.println(" Título: " + content.getTitulo());
                System.out.println(" Subtítulo: " + content.getSubtitulo());
                System.out.println(" Autor: " + content.getAutor());
            }
        }
    }

    public void atualizarConteudo() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o ID do conteúdo que deseja atualizar:");
        long id = scan.nextLong();
        scan.nextLine();  
        Content contentAtualizar = null;

        for (Content content : contents) {
            if (content.getId().equals(id)) {
                contentAtualizar = content;
                break;
            }
        }

        if (contentAtualizar != null) {
            System.out.println("Digite o novo título (atual: " + contentAtualizar.getTitulo() + "):");
            String novoTitulo = scan.nextLine();
            System.out.println("Digite o novo subtítulo (atual: " + contentAtualizar.getSubtitulo() + "):");
            String novoSubtitulo = scan.nextLine();
            System.out.println("Digite o novo autor (atual: " + contentAtualizar.getAutor() + "):");
            String novoAutor = scan.nextLine();
            System.out.println("Digite o novo conteúdo (atual: " + contentAtualizar.getCorpo() + "):");
            String novoConteudo = scan.nextLine();

            contentAtualizar.setTitulo(novoTitulo);
            contentAtualizar.setSubtitulo(novoSubtitulo);
            contentAtualizar.setAutor(novoAutor);
            contentAtualizar.setCorpo(novoConteudo);

            System.out.println("Conteúdo atualizado!");
        } else {
            System.out.println("Conteúdo com ID " + id + " não encontrado.");
        }
    }

    public void excluirConteudo() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o ID do conteúdo que deseja excluir:");
        long id = scan.nextLong();
        scan.nextLine();  
        Content contentExcluir = null;

        for (Content content : contents) {
            if (content.getId().equals(id)) {
                contentExcluir = content;
                break;
            }
        }

        if (contentExcluir != null) {
            contents.remove(contentExcluir);
            System.out.println("Conteúdo excluído!");
        } else {
            System.out.println("Conteúdo com ID " + id + " não encontrado.");
        }
    }
	

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Content other = (Content) obj;
		return Objects.equals(id, other.id);
	}
	
	
}

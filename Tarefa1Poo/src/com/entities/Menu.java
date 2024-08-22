package com.entities;

import java.util.Scanner;

public class Menu {
    private Scanner scan = new Scanner(System.in);
    private Content content = new Content(); 

    public void menuList() {
        System.out.println("MENU");
        System.out.println("1- Fazer Login");
        System.out.println("2- Listar Conteúdos");
        System.out.println("3- Sair");
        System.out.println("Bem-vindo! Qual opção deseja escolher?");
        int option = scan.nextInt();
        scan.nextLine(); 

        switch (option) {
            case 1:
                System.out.println("Digite seu Login");
                String login = scan.nextLine();
                System.out.println("Digite sua senha");
                String senha = scan.nextLine();
                User user = new User((long) (User.getUserList().size() + 1), login, senha);
                menuList2();
                break;
            case 2:
                content.listarConteudos();
                menuList();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Essa opção é inválida");
                menuList();
                break;
        }
    }

    public void menuList2() {
        System.out.println("MENU");
        System.out.println("1- Criar Conteúdo");
        System.out.println("2- Listar Conteúdos");
        System.out.println("3- Atualizar Conteúdo");
        System.out.println("4- Excluir Conteúdo");
        System.out.println("5- Sair");
        System.out.println("Bem-vindo! Qual opção deseja escolher?");
        int option = scan.nextInt();
        scan.nextLine(); 

        switch (option) {
            case 1:
                content.criarConteudo();
                menuList2();
                break;
            case 2:
                content.listarConteudos();
                menuList2();
                break;
            case 3:
                content.atualizarConteudo();
                menuList2();
                break;
            case 4:
                content.excluirConteudo();
                menuList2();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("Essa opção é inválida");
                menuList2();
                break;
        }
    }
}
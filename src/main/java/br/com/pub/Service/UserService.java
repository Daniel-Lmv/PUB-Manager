package br.com.pub.Service;

import br.com.pub.Model.Publicacao;
import br.com.pub.Model.User;
import br.com.pub.Repository.PubRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    PubRepository pubRepository;

    public void inserirNoBanco(User user){
        pubRepository.insert(user);
    }

    public Optional<User> selecionarPeloId(String userId){
        return pubRepository.findById(userId);
    }

    public void atualizarUser(String userId, User novoUser) {
        Optional<User> user = selecionarPeloId(userId);
            if(user.isPresent()){
                User userLocal = user.get();
                BeanUtils.copyProperties(novoUser,userLocal);
                pubRepository.save(userLocal);
            }
    }


    public Publicacao adicionarPub(String userId, Publicacao novaPublicacao){
        ArrayList<Publicacao> listaDePubs;
        Optional<User> user = selecionarPeloId(userId);
        if(user.isEmpty()){
            return null;
        }

        User userLocal = user.get();
        listaDePubs = userLocal.getListaPubs();
        listaDePubs.add(novaPublicacao);
        userLocal.setListaPubs(listaDePubs);
        atualizarUser(userId,userLocal);
        return novaPublicacao;
    }

    public Publicacao alterarPub(String userId, String pubId, Publicacao novaPublicacao){
        ArrayList<Publicacao> listaDePubs;
        Optional<User> user = selecionarPeloId(userId);
        if(user.isEmpty()){
            return null;
        }

        User userLocal = user.get();
        listaDePubs = userLocal.getListaPubs();
        for(Publicacao pub : listaDePubs) {
            if (pub.getPubId().equals(pubId)) {
                BeanUtils.copyProperties(novaPublicacao, pub);
                userLocal.setListaPubs(listaDePubs);
                atualizarUser(userId,userLocal);
                return pub;
            }
        }
        return null;
    }

    public Publicacao deletarPub(String userId, String pubId){
        ArrayList<Publicacao> listaDePubs;
        Optional<User> user = selecionarPeloId(userId);
        if(user.isEmpty()) {
            return null;
        }

        User userLocal = user.get();
        listaDePubs = userLocal.getListaPubs();
        for(Publicacao pub : listaDePubs) {
            if (pub.getPubId().equals(pubId)) {
                listaDePubs.remove(pub);
                userLocal.setListaPubs(listaDePubs);
                atualizarUser(userId,userLocal);
                return pub;
            }
        }
        return null;
    }


}
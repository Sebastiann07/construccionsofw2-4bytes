package app.adapter.out.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.User;
import app.domain.ports.UserPort;
import app.infrastructure.persistence.entities.UserEntity;
import app.infrastructure.persistence.mapper.UserMapper;
import app.infrastructure.persistence.repository.UserRepository;

@Service
public class UserAdapter implements UserPort {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(User user) throws Exception {
        UserEntity entity = UserMapper.toEntity(user);
        userRepository.save(entity);
        if (user.getId() == 0 && entity.getId() != null) {
            user.setId(entity.getId());
        }
    }

    @Override
    public User findById(long id) throws Exception {
        return userRepository.findById(id).map(UserMapper::toDomain).orElse(null);
    }

    @Override
    public User findByUsername(String username) throws Exception {
        return userRepository.findByUsername(username).map(UserMapper::toDomain).orElse(null);
    }

    @Override
    public User delete(User user) throws Exception {
        if (user.getId() == 0) return null;
        userRepository.deleteById(user.getId());
        return user;
    }

    @Override
    public void update(User user) throws Exception {
        UserEntity entity = UserMapper.toEntity(user);
        userRepository.save(entity);
    }
}

package learn.memories.data;

import java.util.List;

import learn.memories.models.Memory;

public interface MemoryRepository {

    List<Memory> findAll() throws DataAccessException;

    Memory findById(int memoryId) throws DataAccessException;

    List<Memory> findShareable(boolean shareable) throws DataAccessException;

    Memory add(Memory memory) throws DataAccessException;

    boolean update(Memory memory) throws DataAccessException;

    boolean deleteById(int memoryId) throws DataAccessException;
}

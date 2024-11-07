package learn.memories.data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import learn.memories.models.Memory;

public class MemoryFileRepositoryTest {

    static final String SEED_FILE_PATH = "./data/memories-seed.txt";
    static final String TEST_FILE_PATH = "./data/memories-test.txt";

    MemoryFileRepository repository = new MemoryFileRepository(TEST_FILE_PATH);

    @BeforeEach
    void setupTest() throws IOException {
        Path seedPath = Paths.get(SEED_FILE_PATH);
        Path testPath = Paths.get(TEST_FILE_PATH);

        Files.copy(seedPath, testPath, StandardCopyOption.REPLACE_EXISTING);
    }

    @Test
    void testAdd() throws DataAccessException {
        Memory memory = new Memory();
        memory.setFrom("A Friend");
        memory.setContent("A special memory.");

        Memory actual = repository.add(memory);
        assertEquals(4, actual.getId());

        List<Memory> all = repository.findAll();
        assertEquals(4, all.size());

        actual = all.get(3);                        // the newly-added memory
        assertEquals(4, actual.getId());
        assertEquals("A Friend", actual.getFrom()); // confirm all fields
        assertEquals("A special memory.", actual.getContent());
        assertFalse(actual.isShareable());
    }

    @Test
    void testDeleteById() throws DataAccessException {
        int count = repository.findAll().size();
        assertTrue(repository.deleteById(1));
        assertFalse(repository.deleteById(1024));
        assertEquals(count - 1, repository.findAll().size());
    }

    @Test
    void testFindAll() throws DataAccessException {
        List<Memory> actual = repository.findAll();
        assertEquals(3, actual.size());
    }

    @Test
    void testFindById() throws DataAccessException {
        Memory memory = repository.findById(2);
        assertNotNull(memory);
        assertEquals("Uncle Sherwin", memory.getFrom());
        assertTrue(memory.isShareable());

        memory = repository.findById(1024);
        assertNull(memory); // id 1024 does not exist, expect null
    }

    @Test
    void testFindShareable() throws DataAccessException {
        List<Memory> actual = repository.findShareable(true);
        assertEquals(2, actual.size()); // seed data has 2 shareable memories

        actual = repository.findShareable(false);
        assertEquals(1, actual.size()); // 1 non-shareable memory
    }

    @Test
    void testUpdate() throws DataAccessException {
        Memory memory = repository.findById(2);
        memory.setFrom("Sherwin");                    // was Uncle Sherwin
        memory.setShareable(false);                   // was true
        assertTrue(repository.update(memory));

        memory = repository.findById(2);
        assertNotNull(memory);                        // confirm the memory exists
        assertEquals("Sherwin", memory.getFrom());    // confirm the memory was updated
        assertFalse(memory.isShareable());

        Memory doesNotExist = new Memory();
        doesNotExist.setId(1024);
        assertFalse(repository.update(doesNotExist)); // can't update a memory that doesn't exist
    }
}

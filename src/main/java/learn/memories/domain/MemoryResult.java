package learn.memories.domain;

import java.util.ArrayList;
import java.util.List;

import learn.memories.models.Memory;

public class MemoryResult {

    private final ArrayList<String> messages = new ArrayList<>();
    private Memory memory;

    public List<String> getErrorMessages() {
        return new ArrayList<>(messages);
    }

    public void addErrorMessage(String message) {
        messages.add(message);
    }

    public boolean isSuccess() {
        // If an error message exists, the operation failed.
        return messages.isEmpty();
    }

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }
}

package me.notechus.poo.lista8.zad4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author notechus.
 */
public class Mailbox {

    private static final Logger log = LoggerFactory.getLogger(Mailbox.class);

    void processMessage(Message message, ActionType action) {
        switch (message.getState()) {
            case RECEIVED:
                processReceivedMessage(message, action);
                break;
            case READ:
                processReadMessage(message, action);
                break;
            case ARCHIVED:
                processArchivedMessage(message, action);
                break;
            case IN_TRASH:
                processTrashMessage(message, action);
                break;
            case DELETED:
                processDeletedMessage(message, action);
                break;
            default:
                throw new IllegalArgumentException("Unrecognized message state " + message.getState());
        }
    }

    private void processDeletedMessage(Message message, ActionType action) {
        throw new IllegalArgumentException("Message" + message.getId() +
                " does not exist. Cannot perform action " + action);
    }

    private void processTrashMessage(Message message, ActionType action) {
        switch (action) {
            case RESTORE:
                message.setState(MessageStateType.READ);
                log.info("Message has been restored {}", message.getId());
                break;
            case DELETE_PERMANENTLY:
                message.setState(MessageStateType.DELETED);
                log.info("Message has been deleted permanently {}", message.getId());
            default:
                throw new IllegalArgumentException("Action not permitted " + action);
        }
    }

    private void processArchivedMessage(Message message, ActionType action) {
        switch (action) {
            case MOVE_TO_TRASH:
                message.setState(MessageStateType.IN_TRASH);
                log.info("Message has been removed {}", message.getId());
                break;
            case MARK_UNREAD:
                message.setState(MessageStateType.RECEIVED);
                log.info("Marked message as unread {}", message.getId());
            default:
                throw new IllegalArgumentException("Action not permitted " + action);
        }
    }

    private void processReadMessage(Message message, ActionType action) {
        switch (action) {
            case MARK_UNREAD:
                message.setState(MessageStateType.RECEIVED);
                log.info("Marked message as unread {}", message.getId());
                break;
            case ARCHIVIZE:
                message.setState(MessageStateType.ARCHIVED);
                log.info("Archived message {}", message.getId());
                break;
            case MOVE_TO_TRASH:
                message.setState(MessageStateType.IN_TRASH);
                log.info("Message has been removed {}", message.getId());
                break;
            default:
                throw new IllegalArgumentException("Action not permitted " + action);
        }
    }

    private void processReceivedMessage(Message message, ActionType action) {
        switch (action) {
            case ARCHIVIZE:
                message.setState(MessageStateType.ARCHIVED);
                log.info("Archived message {}", message.getId());
                break;
            case MARK_READ:
                message.setState(MessageStateType.READ);
                log.info("Message has been read {}", message.getId());
                break;
            case MOVE_TO_TRASH:
                message.setState(MessageStateType.IN_TRASH);
                log.info("Message has been removed {}", message.getId());
                break;
            default:
                throw new IllegalArgumentException("Action not permitted " + action);
        }
    }
}

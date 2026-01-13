package com.jstargram.client.view;

import com.jstargram.client.network.ClientService;
import javax.swing.*;
import java.awt.*;

// 채팅방 하나의 화면 UI
public class ChatPanel extends JPanel {

/**
	 * */
	private static final long serialVersionUID = 1L;
private final String roomId;

private final ClientService client; 

private JTextArea chatArea;
private JTextField inputField;
private JButton sendButton;

public ChatPanel(String roomId, ClientService client) {
   this.roomId = roomId;
   this.client = client;
   initComponents();
}

private void initComponents() {
   setLayout(new BorderLayout());

   chatArea = new JTextArea();
   chatArea.setEditable(false);
   JScrollPane scrollPane = new JScrollPane(chatArea);

   inputField = new JTextField();
   sendButton = new JButton("보내기");

   JPanel bottomPanel = new JPanel(new BorderLayout());
   bottomPanel.add(inputField, BorderLayout.CENTER);
   bottomPanel.add(sendButton, BorderLayout.EAST);

   add(scrollPane, BorderLayout.CENTER);
   add(bottomPanel, BorderLayout.SOUTH);

   inputField.addActionListener(e -> sendCurrentMessage());
   sendButton.addActionListener(e -> sendCurrentMessage());
}

private void sendCurrentMessage() {
   String text = inputField.getText().trim();
   if (text.isEmpty()) return;

   // ClientService의 통합된 sendChatMessage 메소드 호출
   client.sendChatMessage(roomId, text);
   
   inputField.setText("");
}

public void appendMessage(String sender, String content) {
   SwingUtilities.invokeLater(() -> {
       // 욕설 필터링 로직은 나중에 서버에서 처리하므로, 여기서는 바로 화면에 추가
       chatArea.append(sender + ": " + content + "\n");
       chatArea.setCaretPosition(chatArea.getDocument().getLength());
   });
}

public void appendSystemMessage(String text) {
   SwingUtilities.invokeLater(() -> {
       chatArea.append("[SYSTEM] " + text + "\n");
       chatArea.setCaretPosition(chatArea.getDocument().getLength());
   });
}

public String getRoomId() {
   return roomId;
}
}

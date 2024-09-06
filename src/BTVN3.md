ta có một chuỗi node
1 -> 2 -> 3 -> 4 -> 5
với index = 3, thứ tự luôn bắt đầu từ 0 => số ở index sẽ là số 4

Trường hợp i <= index:
i = 1 => temp = 1, temp.next = 2 => temp = temp.next = 2
i = 2 => temp = 2, temp.next = 3 => temp = temp.next = 3
i = 3 => temp = 3, temp.next = 4 => temp = temp.next = 4
=> temp = 4 chính xác vị trí node

Trường hợp i < index:
i = 1 => temp = 1, temp.next = 2 => temp = temp.next = 2
i = 2 => temp = 2, temp.next = 3 => temp = temp.next = 3
=> temp = 3 ngay trước vị trí node

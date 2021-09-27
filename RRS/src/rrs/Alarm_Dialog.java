package rrs;

import javax.swing.JOptionPane;

public class Alarm_Dialog {
	public void non_existing() {
		JOptionPane.showMessageDialog(null, "회원 정보와 일치하지 않습니다.", "Warning", JOptionPane.WARNING_MESSAGE);
	}
	public void empty() {
		JOptionPane.showMessageDialog(null, "빈칸 없이 작성해주세요.", "Warning", JOptionPane.WARNING_MESSAGE);
	}
	public void checkDuplication() {
		JOptionPane.showMessageDialog(null, "전화번호 중복 확인을 해주세요.", "Warning", JOptionPane.WARNING_MESSAGE);
	}
	public void successCheck() {
		JOptionPane.showMessageDialog(null, "중복 확인에 성공하였습니다.", "Success", JOptionPane.INFORMATION_MESSAGE);
	}
	public void failCheck() {
		JOptionPane.showMessageDialog(null, "중복 확인에 실패하였습니다.", "Fail", JOptionPane.WARNING_MESSAGE);
	}
	public int askDelete() {
		int ans = JOptionPane.showConfirmDialog(null, "삭제하시겠습니까?", "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
		return ans;
	}
	public void cookTime(int m) {
		JOptionPane.showMessageDialog(null, m+" 분", "예상조리시간", JOptionPane.INFORMATION_MESSAGE);
	}
	public void checkQuantity() {
		JOptionPane.showMessageDialog(null, "수량을 선택해주세요.", "Warning", JOptionPane.WARNING_MESSAGE);
	}
	public void completeReservation() {
		JOptionPane.showMessageDialog(null, "예약이 완료되었습니다.", "Success", JOptionPane.INFORMATION_MESSAGE);
	}
	public void checkTime() {
		JOptionPane.showMessageDialog(null, "예약 시간을 다시 확인해주세요.", "Warning", JOptionPane.WARNING_MESSAGE);
	}
	public void impossibleCancel() {
		JOptionPane.showMessageDialog(null, "취소할 수 없는 예약입니다.", "Warning", JOptionPane.WARNING_MESSAGE);
	}
	public int askCancel() {
		int ans = JOptionPane.showConfirmDialog(null, "취소하시겠습니까?", "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
		return ans;
	}
}

package rrs;

import javax.swing.JOptionPane;

public class Alarm_Dialog {
	public void non_existing() {
		JOptionPane.showMessageDialog(null, "ȸ�� ������ ��ġ���� �ʽ��ϴ�.", "Warning", JOptionPane.WARNING_MESSAGE);
	}
	public void empty() {
		JOptionPane.showMessageDialog(null, "��ĭ ���� �ۼ����ּ���.", "Warning", JOptionPane.WARNING_MESSAGE);
	}
	public void checkDuplication() {
		JOptionPane.showMessageDialog(null, "��ȭ��ȣ �ߺ� Ȯ���� ���ּ���.", "Warning", JOptionPane.WARNING_MESSAGE);
	}
	public void successCheck() {
		JOptionPane.showMessageDialog(null, "�ߺ� Ȯ�ο� �����Ͽ����ϴ�.", "Success", JOptionPane.INFORMATION_MESSAGE);
	}
	public void failCheck() {
		JOptionPane.showMessageDialog(null, "�ߺ� Ȯ�ο� �����Ͽ����ϴ�.", "Fail", JOptionPane.WARNING_MESSAGE);
	}
	public int askDelete() {
		int ans = JOptionPane.showConfirmDialog(null, "�����Ͻðڽ��ϱ�?", "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
		return ans;
	}
	public void cookTime(int m) {
		JOptionPane.showMessageDialog(null, m+" ��", "���������ð�", JOptionPane.INFORMATION_MESSAGE);
	}
	public void checkQuantity() {
		JOptionPane.showMessageDialog(null, "������ �������ּ���.", "Warning", JOptionPane.WARNING_MESSAGE);
	}
	public void completeReservation() {
		JOptionPane.showMessageDialog(null, "������ �Ϸ�Ǿ����ϴ�.", "Success", JOptionPane.INFORMATION_MESSAGE);
	}
	public void checkTime() {
		JOptionPane.showMessageDialog(null, "���� �ð��� �ٽ� Ȯ�����ּ���.", "Warning", JOptionPane.WARNING_MESSAGE);
	}
	public void impossibleCancel() {
		JOptionPane.showMessageDialog(null, "����� �� ���� �����Դϴ�.", "Warning", JOptionPane.WARNING_MESSAGE);
	}
	public int askCancel() {
		int ans = JOptionPane.showConfirmDialog(null, "����Ͻðڽ��ϱ�?", "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
		return ans;
	}
}

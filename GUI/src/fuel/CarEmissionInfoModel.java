package fuel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class CarEmissionInfoModel extends AbstractTableModel {

	private static final String[] COLUMN_NAMES = new String[] { "Manufacturer", "Model", "Engine Size", "Fuel Type",
			"Co2 Emission" };

	private final List<CarEmissionInfo> carEmissionInfos;

	public CarEmissionInfoModel(List<CarEmissionInfo> carEmissionInfos) {
		this.carEmissionInfos = carEmissionInfos;
	}

	@Override
	public int getRowCount() {
		return carEmissionInfos.size();
	}

	@Override
	public int getColumnCount() {
		return COLUMN_NAMES.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		CarEmissionInfo item = carEmissionInfos.get(rowIndex);

		switch (columnIndex) {
		case 0: {

			return item.getManufacturer();
		}
		case 1: {

			return item.getModel();
		}
		case 2: {

			return item.getEngineSize();
		}
		case 3: {

			return item.getFuelType();
		}
		case 4: {

			return item.getCo2Emission();
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + columnIndex);
		}

	}

	
	@Override
	public String getColumnName(int column) {
		return COLUMN_NAMES[column];
	}

	
	
}

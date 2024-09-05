import { useMemo } from 'react';
import { Bar } from 'react-chartjs-2';
import './style.css'
import { Chart as ChartJS, CategoryScale, LinearScale, BarElement, Title, Tooltip, Legend } from 'chart.js';

ChartJS.register(CategoryScale, LinearScale, BarElement, Title, Tooltip, Legend);

interface DataItem {
  registro: number;
  data: string;
  hora: string;
  hostname: string;
  ipAddress: string;
  macAddress: string;
  marca: string;
  modelo: string;
  numSerie: string;
  versao: string;
  imobilizado: string;
}

interface ChartComponentProps {
  data: DataItem[];
}

const ChartComponent: React.FC<ChartComponentProps> = ({ data }) => {
  const aggregatedData = useMemo(() => {
    // Usar um objeto para contar o número de registros por data
    const dataCountMap = new Map<string, number>();

    data.forEach(item => {
      if (dataCountMap.has(item.data)) {
        dataCountMap.set(item.data, dataCountMap.get(item.data)! + 1);
      } else {
        dataCountMap.set(item.data, 1);
      }
    });

    const labels = Array.from(dataCountMap.keys());
    const values = Array.from(dataCountMap.values());

    return { labels, values };
  }, [data]);

  // Obter uma marca única (presumindo que todos os itens têm a mesma marca)
  const uniqueBrands = Array.from(new Set(data.map(item => item.marca)));
  const label = uniqueBrands.length > 0 ? uniqueBrands[0] : 'Marca';

  const chartData = {
    labels: aggregatedData.labels,
    datasets: [
      {
        label: `Número de Registros (${label})`,
        data: aggregatedData.values,
        backgroundColor: 'rgba(54, 162, 235, 0.4)', // Azul forte
        borderColor: 'rgba(54, 162, 235, 1)', // Azul forte
        borderWidth: 1, // Largura da borda ajustada para melhor visualização
        borderRadius: 8, // Bordas arredondadas para as barras
        barThickness: 3, // Largura das barras ajustada
        hoverBackgroundColor: 'rgba(54, 162, 235, 0.6)', // Cor de fundo ao passar o mouse
        hoverBorderColor: 'rgba(54, 162, 235, 1)', // Cor da borda ao passar o mouse
      },
    ],
  };

  return <Bar data={chartData} />;
};

export default ChartComponent;

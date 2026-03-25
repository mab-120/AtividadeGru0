import {View, Text, TouchableOpacity, StyleSheet} from 'react-native';

export default function AboutScreen({ navigation }) {
  return (
    <View style={styles.container}>
    <Text style={styles.title}>Sobre</Text>

    <Text style={styles.text}>Aqui você pode conhecer melhor sobre a empresa.
     </Text>



        <TouchableOpacity
    style={styles.button}
    onPress={() => navigation.navigate('Services')}>
    <Text style={styles.buttonText}>Serviços</Text>
    </TouchableOpacity>

    </View>
  );
}

const styles=StyleSheet.create({
  container: {
    flex: 1,
    justifyContent:'center',
    display: 'flex',
    padding: 20,
    backgroundColor: '#ffff',
   
  },
  title: {
    fontSize: 26,
    fontWeight:'bold',
  },
  text: {
    marginVertical: 15,
    textAlign: 'justify'
  },
  button: {
    backgroundColor: '#556B2F',
    padding: 16,
    borderRadius: 100,
    alignItems: 'center',
    width: '80%',
    marginVertical: 20,
  },
  buttonText: {
    color: '#fff',
    fontWeight: 'bold',
    fontSize: 20,
  }
});